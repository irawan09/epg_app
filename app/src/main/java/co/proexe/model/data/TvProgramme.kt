package co.proexe.model.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

data class TvProgramme(
    @SerializedName("id")
    @Expose
    val id: Int,

    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("imageUrl")
    @Expose
    val imageUrl: String,

    @SerializedName("type")
    @Expose
    val type: String,

    @SerializedName("category")
    @Expose
    val category: TvProgrammeCategory,

    @SerializedName("isFavourite")
    @Expose
    val isFavourite: Boolean,

    @SerializedName("startTimeDateRaw")
    @Expose
    val startTime: String,

    @SerializedName("endTimeDateRaw")
    @Expose
    val endTime: String,

    @SerializedName("progressPercent")
    @Expose
    val progressPercent: Int
)