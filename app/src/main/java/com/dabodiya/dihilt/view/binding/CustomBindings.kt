package com.dabodiya.dihilt.view.binding

import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.google.android.material.snackbar.Snackbar

/**
 * Visibility Visible or Gone
 */
@BindingAdapter("visibleOrGone")
fun View.visibleOrGone(isVisible: Boolean?) {
    if (isVisible != null) {
        visibility = if (isVisible) View.VISIBLE else View.GONE
    }
}

/**
 * Visibility Visible or Invisible
 */
@BindingAdapter("visibleOrInvisible")
fun View.visibleOrInvisible(isVisible: Boolean?) {
    if (isVisible != null) {
        visibility = if (isVisible) View.VISIBLE else View.INVISIBLE
    }
}

/**
 * Scrollable or Not
 */
@BindingAdapter("scrollable")
fun TextView.scrollable(scrollable: Boolean?) {
    if (scrollable != null && scrollable) {
        movementMethod = ScrollingMovementMethod()
    }
}

/**
 * Set Snackbar
 */
@BindingAdapter("snackbarMessage")
fun View.snackBarMessage(message: String?) {
    if (!message.isNullOrEmpty()) {
        Snackbar.make(this, message, Snackbar.LENGTH_SHORT).show()
    }


}