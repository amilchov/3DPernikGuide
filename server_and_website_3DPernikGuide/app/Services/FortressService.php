<?php

namespace App\Services;

use App\Models\Fortress;
use App\Models\FortressUser;
use App\Http\Requests\FortressUserRequest;
use App\Repositories\UserRepository;

class FortressService
{
    /**
     * @var UserRepository
     */
    private $userRepository;

    /**
     * FortressUsersController constructor.
     * @param UserRepository $userRepository
     */
    public function __construct(UserRepository $userRepository)
    {
        $this->userRepository = $userRepository;
    }

    /**
     *
     * @param FortressUserRequest $request
     * @return mixed
     */
    public function update(FortressUserRequest $request)
    {
        $user = $this->userRepository->getUserByToken($request);

        $date = $user->fortressUser->date;
        $last_visit_fortress = $user->fortressUser->last_visit_fortress;

        $total_count = FortressUser::where('date', '=', $date)
            ->sum('count_fortress');

        $last_visit = FortressUser::where('last_visit_fortress', '=', $last_visit_fortress)
            ->orderBy('last_visit_fortress', 'DESC')
            ->first('last_visit_fortress')
            ->{'last_visit_fortress'};

        return $user;
    }
}
