<?php

namespace App\Services;

use App\Http\Requests\LoginUserRequest;
use App\Http\Requests\RegisterUserRequest;
use App\Models\Find;
use App\Http\Requests\UserUpdateRequest;
use App\Repositories\UserRepository;
use App\Models\User;
use Illuminate\Http\JsonResponse;
use Illuminate\Support\Str;

class UserService
{
    /**
     * @var UserRepository
     */
    private UserRepository $userRepository;

    /**
     * UserService constructor.
     * @param UserRepository $userRepository
     */
    public function __construct(UserRepository $userRepository)
    {
        $this->userRepository = $userRepository;
    }

    /**
     * @param LoginUserRequest $request
     * @return JsonResponse
     */
    public function login(LoginUserRequest $request): JsonResponse
    {
        $validated = $request->validated();

        if (!auth()->attempt($validated)) {
            return response()->json(['message' => 'Email address or/and password are incorrect.'], 401);
        }

        return response()->json(auth()->user());
    }

    /**
     * Here we register our users with relevant relationships.
     *
     * @param RegisterUserRequest $request
     * @return mixed
     */
    public function register(RegisterUserRequest $request)
    {
        $validated = $request->validated();

        $finds = Find::all();

        $user = User::create([
            'first_name' => $validated['first_name'],
            'middle_name' => $validated['middle_name'],
            'last_name' => $validated['last_name'],
            'email' => $validated['email'],
            'password' => $validated['password'],
            'token' => Str::random(255),
        ]);

        $user->fortressUser()->create([
            'count_fortress' => null,
            'last_visit_fortress' => null
        ]);

        $user->museumUser()->create([
            'count_museum' => null,
            'last_visit_museum' => null
        ]);

        $user->finds()->attach($finds);

        return response()->json([
            "user" => $user
        ]);
    }
}