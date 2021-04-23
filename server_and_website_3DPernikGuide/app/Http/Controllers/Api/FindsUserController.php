<?php

namespace App\Http\Controllers\Api;

use App\Models\FindsUser;
use App\Http\Controllers\Controller;
use App\Http\Requests\FindsUserRequest;
use App\Repositories\UserRepository;
use Illuminate\Http\JsonResponse;
use Illuminate\Http\Request;

class FindsUserController extends Controller
{
    /**
     * @var UserRepository
     */
    private UserRepository $userRepository;

    /**
     * FindsUserController constructor.
     * @param UserRepository $userRepository
     */
    public function __construct(UserRepository $userRepository)
    {
        $this->userRepository = $userRepository;
    }

    /**
     * @param Request $request
     * @return JsonResponse
     */
    public function index(Request $request): JsonResponse
    {
        $user = $this->userRepository->getUserByToken($request);

        $name = $user->first_name . ' ' . $user->middle_name . ' ' . $user->last_name;

        $finds = FindsUser::with('find')->where('user_id', $user->id)->get();

        return response()->json([
            "name" => $name,
            "finds" => $finds
        ]);
    }

    /**
     * @param FindsUserRequest $request
     * @return JsonResponse
     */
    public function update(FindsUserRequest $request): JsonResponse
    {
        $user = $this->userRepository->getUserByToken($request);

        $user->finds()->where('find_id', $request->find_id)->update(['status' => $request->status]);

        return response()->json([
            "finds_user" => [
                "find_id" => $request->find_id,
                "user_id" => $user->findsUser->user_id,
                "status" => $request->status
            ]
        ]);
    }
}
