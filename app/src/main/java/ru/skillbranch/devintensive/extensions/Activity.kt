package ru.skillbranch.devintensive.extensions

import android.app.Activity
import android.content.Context
import android.graphics.Rect
import android.util.Log
import android.view.View
import android.view.ViewTreeObserver
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_profile.*


//fun Activity.hideKeyboard() {
//    val inputManager: InputMethodManager =
//        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//    inputManager.hideSoftInputFromWindow(currentFocus.windowToken, InputMethodManager.SHOW_FORCED)
//
//}

//fun Activity.isKeyboardOpen(): Boolean {
//    val r = Rect()
//    rootView.getWindowVisibleDisplayFrame(r)
//    val keyBoard = rootView.height - (r.bottom - r.top)
//    return (keyBoard > 128)
//}
//fun Activity.isKeyboardClosed(): Boolean{
//    val r = Rect()
//    rootView.getWindowVisibleDisplayFrame(r)
//    val keyBoard = rootView.height - (r.bottom - r.top)
//    return (keyBoard < 128)
//}