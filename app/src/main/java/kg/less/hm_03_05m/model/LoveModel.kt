package kg.less.hm_03_05m.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class LoveModel (
    @SerializedName("fname")
    val firstName: String,
    @SerializedName("sname")
    val secondName: String,
    @SerializedName("percentage")
    val percentage: String,
    @SerializedName("result")
    val result: String
): Serializable