package co.proexe.model.data

import com.google.gson.annotations.SerializedName

enum class TvProgrammeCategory {
    @SerializedName("ALL")
    ALL,
    @SerializedName("KIDS")
    KIDS,
    @SerializedName("EDUCATIONAL")
    EDUCATIONAL,
    @SerializedName("MOVIES_AND_SERIES")
    MOVIES_AND_SERIES,
    @SerializedName("INFO")
    INFO,
    @SerializedName("MUSIC")
    MUSIC,
    @SerializedName("GENERAL")
    GENERAL,
    @SerializedName("SPORT")
    SPORT,
    @SerializedName("LIFESTYLE")
    LIFESTYLE
}