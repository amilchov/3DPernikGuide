<?php

namespace App\Models;

use Illuminate\Contracts\Auth\MustVerifyEmail;
use Illuminate\Database\Eloquent\Relations\BelongsToMany;
use Illuminate\Database\Eloquent\Relations\HasOne;
use Illuminate\Foundation\Auth\User as Authenticatable;
use Illuminate\Notifications\Notifiable;
use Illuminate\Database\Eloquent\Builder;
use Illuminate\Support\Facades\Hash;

class User extends Authenticatable implements MustVerifyEmail
{
    use Notifiable;

    /**
     * The attributes that are mass assignable.
     *
     * @var array
     */
    protected $fillable = [
        'first_name',
        'middle_name',
        'last_name',
        'email',
        'password',
        'token',
        'count_fortress',
        'last_visit_fortress',
        'count_museum',
        'last_visit_museum',
        'created_at'
    ];

    /**
     * The attributes that should be hidden for arrays.
     *
     * @var array
     */
    protected $hidden = [
        'password',
        'remember_token',
    ];

    /**
     * The attributes that should be cast to native types.
     *
     * @var array
     */
    protected $casts = [
        'email_verified_at' => 'datetime',
    ];

    /**
     * @return HasOne
     */
    public function fortressUser(): HasOne
    {
        return $this->hasOne('App\Models\FortressUser', 'user_id', 'id');
    }

    /**
     * @return HasOne
     */
    public function museumUser(): HasOne
    {
        return $this->hasOne('App\Models\MuseumUser', 'user_id', 'id');
    }

    /**
     * @return BelongsToMany
     */
    public function finds(): BelongsToMany
    {
        return $this->belongsToMany('App\Models\Find', 'finds_user');
    }

    /**
     * @return HasOne
     */
    public function findsUser(): HasOne
    {
        return $this->hasOne('App\Models\FindsUser');
    }

    /**
     * @param $value
     */
    public function setPasswordAttribute($value): void
    {
        $this->attributes['password'] = Hash::make($value);
    }

    /**
     * Scopes a query to only include active users.
     *
     * @param Builder $query
     * @param string $context
     * @return Builder
     */
    public function scopeTopFiveUsers(Builder $query, string $context): Builder
    {
        return $query
            ->select(['user_id', 'first_name', 'middle_name', 'last_name', 'count_' . $context, 'last_visit_' . $context])
            ->from($context . '_user')
            ->whereNotNull(['count_' . $context, 'last_visit_' . $context])
            ->join('users', $context . '_user.user_id', '=', 'users.id')
            ->orderBy('count_' . $context, 'DESC')
            ->orderBy('last_visit_' . $context, 'DESC');
    }
}
