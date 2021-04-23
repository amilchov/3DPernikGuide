<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Http\Requests\FortressUserRequest;
use App\Repositories\UserRepository;
use App\Models\FortressUser;
use App\Services\FortressService;
use Illuminate\Http\JsonResponse;
use Illuminate\Http\Request;
use Illuminate\Http\Response;

class FortressUsersController extends Controller
{
    /**
     * @var UserRepository
     */
    private UserRepository $userRepository;
    /**
     * @var FortressService
     */
    private FortressService $fortressService;

    /**
     * FortressUsersController constructor.
     * @param UserRepository $userRepository
     * @param FortressService $fortressService
     */
    public function __construct(UserRepository $userRepository, FortressService $fortressService)
    {
        $this->userRepository = $userRepository;
        $this->fortressService = $fortressService;
    }

    /**
     * @return JsonResponse
     */
    public function index()
    {
        $fortress = $this->userRepository->getSightsData(FortressUser::class, 'fortress');

        return response()->json([
            "fortress" => $fortress
        ]);
    }

    /**
     * @param Request $request
     * @return JsonResponse
     */
    public function show(Request $request)
    {
        $user = $this->userRepository->getUserByToken($request);

        return response()->json([
            "fortress" => [
                "count_fortress" => $user->fortressUser->count_fortress,
                "last_visit_fortress" => $user->fortressUser->last_visit_fortress
            ],
        ]);
    }

    /**
     * @param FortressUserRequest $request
     * @return JsonResponse|Response
     */
    public function update(FortressUserRequest $request)
    {
        $user = $this->userRepository->getUserByToken($request);

        $user->fortressUser->update($request->validated());

        $this->fortressService->update($request);

        return response()->json([
            "fortress_user" => [
                "user_id" => $user->fortressUser->user_id,
                "count_fortress" => $user->fortressUser->count_fortress,
                "last_visit_fortress" => $user->fortressUser->last_visit_fortress,
                "date" => $user->fortressUser->date
            ]
        ]);
    }
}
