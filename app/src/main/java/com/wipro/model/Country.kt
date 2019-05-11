package com.wipro.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Digvijay Singh on 11/5/19.
 */
class Country(@SerializedName("title")
              @Expose
              var title: String,
              @SerializedName("rows")
@Expose
var rows: MutableList<Row>? ) {



    inner class Row ( @SerializedName("title")
                      @Expose
                      var title: String ,
                      @SerializedName("description")
    @Expose
    var description: String,
    @SerializedName("imageHref")
    @Expose
    var imageHref: String )

}
