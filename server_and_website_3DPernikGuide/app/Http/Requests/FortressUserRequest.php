<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;

class FortressUserRequest extends FormRequest
{
    /**
     * Determine if the user is authorized to make this request.
     *
     * @return bool
     */
    public function authorize()
    {
        return true;
    }

    /**
     * Get the validation rules that apply to the request.
     *
     * @return array
     */
    public function rules()
    {
        return [
            'count_fortress' => 'required|integer',
            'last_visit_fortress' => 'required|date',
            'date' => 'required'
        ];
    }
}
