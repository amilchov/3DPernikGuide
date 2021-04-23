<?php

namespace App\Services;

use App\Models\Museum;
use App\Models\MuseumUser;
use App\Http\Requests\MuseumUserRequest;
use App\Repositories\UserRepository;

class MuseumService
{
    /**
     * @var UserRepository
     */
    private UserRepository $userRepository;

    /**
     * MuseumUsersController constructor.
     * @param UserRepository $userRepository
     */
    public function __construct(UserRepository $userRepository)
    {
        $this->userRepository = $userRepository;
    }

    /**
     *
     * @param MuseumUserRequest $request
     * @return mixed
     */
    public function update(MuseumUserRequest $request)
    {
        $user = $this->userRepository->getUserByToken($request);

        $date = $user->museumUser->date;
        $last_visit_museum = $user->museumUser->last_visit_museum;

        $total_count = MuseumUser::where('date', '=', $date)
            ->sum('count_museum');

        $last_visit = MuseumUser::where('last_visit_museum', '=', $last_visit_museum)
            ->orderBy('last_visit_museum', 'DESC')
            ->first('last_visit_museum')
            ->{'last_visit_museum'};

        return $user;
    }
}
