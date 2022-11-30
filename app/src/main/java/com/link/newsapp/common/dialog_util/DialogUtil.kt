package com.link.newsapp.common.dialog_util

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AlertDialog
import com.link.newsapp.databinding.DialogErrorViewBinding

object DialogUtil {


    fun showErrorDialog(
        context: Context,
        view: DialogErrorViewBinding,
        message: String,
        retry: () -> Unit,
        cancel: () -> Unit
    ): AlertDialog {

        val alertDialog = AlertDialog.Builder(context).apply {
            setView(view.root)
            setCancelable(false)
        }.create()
        alertDialog.apply {
            view.tvMessage.text = message
            view.btnCancel.setOnClickListener {
                cancel.invoke()
            }

            view.btnRetry.setOnClickListener {
                retry.invoke()
            }
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        }.show()
        return alertDialog
    }

}