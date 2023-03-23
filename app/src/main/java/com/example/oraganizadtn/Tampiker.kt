package com.example.oraganizadtn

import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.icu.text.LocaleDisplayNames.DialectHandling
import android.os.Bundle
import android.view.ViewConfiguration.get
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import java.lang.reflect.Array.get
import java.util.Calendar

class Tampiker (val listener:(String)->Unit):DialogFragment(),TimePickerDialog.OnTimeSetListener{

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendario:Calendar=Calendar.getInstance()
        val hora :Int=calendario.get(Calendar.HOUR_OF_DAY)
        val min :Int=calendario.get(Calendar.MINUTE)

        val dialog = TimePickerDialog(activity as Context,this,hora,min,false)
return dialog

    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
     listener("$hourOfDay:$minute")
    }


}