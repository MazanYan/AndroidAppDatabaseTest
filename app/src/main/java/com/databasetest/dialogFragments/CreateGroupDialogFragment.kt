package com.databasetest.dialogFragments;

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import com.databasetest.R


@SuppressLint("ValidFragment")
class CreateGroupDialogFragment : DialogFragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        this.dialog.setTitle(R.string.create_group)
        val rootView = inflater.inflate(R.layout.create_group_layout, container)

        return rootView
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}