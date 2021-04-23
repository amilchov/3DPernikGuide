<?php

namespace App\Http\Middleware;

use Closure;
use Illuminate\Http\Request;

class AppKey
{
    /**
     * Handle an incoming request.
     *
     * @param Request $request
     * @param Closure $next
     * @return mixed
     */
    public function handle(Request $request, Closure $next)
    {
        $token = $request->header('Application');

        if ($token != config('app.name'))
        {
            return response()->json(['message' => 'Application key not found'], 401);
        }

        return $next($request);
    }
}
