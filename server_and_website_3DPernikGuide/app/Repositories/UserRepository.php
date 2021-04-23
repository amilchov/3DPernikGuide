<?php

namespace App\Repositories;

use App\Models\User;
use Illuminate\Http\Request;

class UserRepository
{
    /**
     * Display a listing of the resource.
     *
     * @param string $model
     * @param string $context
     * @return array
     */
    public function getSightsData(string $model, string $context): array
    {
        $total_count = $model::sum('count_' . $context);

        $last_visit = $model::orderBy('last_visit_' . $context, 'DESC')
            ->first('last_visit_' . $context)
            ->{'last_visit_' . $context};

        $top_five_users = User::topFiveUsers($context)->take(5)->get();

        return [
            'total_count' => $total_count,
            'last_visited' => $last_visit,
            'users' => $top_five_users
        ];
    }

    /**
     * @param Request $request
     * @return mixed
     */
    public function getUserByToken(Request $request)
    {
        $token = $request->header('Authorization');

        return User::where('token', $token)->firstOrFail();
    }
}
