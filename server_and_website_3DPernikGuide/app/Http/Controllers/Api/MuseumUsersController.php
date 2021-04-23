<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Http\Requests\MuseumUserRequest;
use App\Models\MuseumUser;
use App\Repositories\UserRepository;
use App\Services\MuseumService;
use Illuminate\Http\JsonResponse;
use Illuminate\Http\Request;
use Illuminate\Http\Response;

class MuseumUsersController extends Controller
{
    /**
     * @var UserRepository
     */
    private UserRepository $userRepository;

    /**
     * @var MuseumService
     */
    private MuseumService $museumService;

    /**
     * FortressUsersController constructor.
     * @param UserRepository $userRepository
     * @param MuseumService $museumService
     */
    public function __construct(UserRepository $userRepository, MuseumService $museumService)
    {
        $this->userRepository = $userRepository;
        $this->museumService = $museumService;
    }

    /**
     * @return JsonResponse
     */
    public function index(): JsonResponse
    {
        $museum = $this->userRepository->getSightsData(MuseumUser::class, 'museum');

        return response()->json([
            "museum" => $museum
        ]);
    }

    /**
     * @param Request $request
     * @return JsonResponse
     */
    public function show(Request $request): JsonResponse
    {
        $user = $this->userRepository->getUserByToken($request);

        return response()->json([
            "museum" => [
                "count_museum" => $user->museumUser->count_museum,
                "last_visit_museum" => $user->museumUser->last_visit_museum
            ]
        ]);
    }

    /**
     * @param MuseumUserRequest $request
     * @return JsonResponse|Response
     */
    public function update(MuseumUserRequest $request)
    {
        $user = $this->userRepository->getUserByToken($request);

        $user->museumUser->update($request->validated());

        $this->museumService->update($request);

        return response()->json([
            "museum_user" => [
                "user_id" => $user->museumUser->user_id,
                "count_museum" => $user->museumUser->count_museum,
                "last_visit_museum" => $user->museumUser->last_visit_museum,
                "date" => $user->museumUser->date
            ]
        ]);
    }
}