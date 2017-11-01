package com.example.wangpeng.mykotlinapplication.bean

import android.os.Parcel
import android.os.Parcelable
import android.support.v4.os.ParcelableCompat

/**
 * Created by WangPeng on 2017/10/21.
 */
data class ResultNew constructor(
        val title: String,
        val content: String,
        val img_width: String,
        val full_title: String,
        val pdate: String,
        val src: String,
        val img_length: String,
        val img: String,
        val url: String,
        val pdate_src: String
) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(content)
        parcel.writeString(img_width)
        parcel.writeString(full_title)
        parcel.writeString(pdate)
        parcel.writeString(src)
        parcel.writeString(img_length)
        parcel.writeString(img)
        parcel.writeString(url)
        parcel.writeString(pdate_src)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ResultNew> {
        override fun createFromParcel(parcel: Parcel): ResultNew {
            return ResultNew(parcel)
        }

        override fun newArray(size: Int): Array<ResultNew?> {
            return arrayOfNulls(size)
        }
    }
}