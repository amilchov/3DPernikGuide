<?php

namespace App\Http\Controllers\Pages;

use App\Http\Controllers\Controller;
use App\Mail\SendMail;
use Illuminate\Contracts\Foundation\Application;
use Illuminate\Contracts\Support\Renderable;
use Illuminate\Http\RedirectResponse;
use Illuminate\Routing\Redirector;
use Illuminate\Support\Facades\Mail;
use Illuminate\Http\Request;

class PagesController extends Controller
{
    /**
     * Show the home page of our application.
     *
     * @return Renderable
     */
    public function home(): Renderable
    {
        return view('pages.home');
    }

    /**
     * @param Request $request
     * @return Application|RedirectResponse|Redirector
     */
    public function contact(Request $request)
    {
        $data = [
            'first_name' => $request->first_name,
            'last_name' => $request->last_name,
            'email' => $request->email,
            'subject' => $request->subject,
            'message' => $request->message
        ];

        Mail::to(config('app.mails.email'))->send(new SendMail($data));

        return redirect('#contact_page')->with('status', 'Благодарим Ви, че изпратихте вашето съобщение!');
    }
}