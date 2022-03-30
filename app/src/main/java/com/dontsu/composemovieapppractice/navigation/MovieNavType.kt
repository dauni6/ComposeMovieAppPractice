package com.dontsu.composemovieapppractice.navigation

import android.os.Bundle
import androidx.navigation.NavType
import com.dontsu.composemovieapppractice.model.Movie
import com.google.gson.Gson

/*
* https://stackoverflow.com/questions/65610003/pass-parcelable-argument-with-compose-navigation
* 여기에서 커스텀으로 MovieNavType을 만들도록 하였다. 근데 뭔가 완벽한 방법은 아닌듯하다
*/
class MovieNavType : NavType<Movie>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): Movie? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): Movie {
        return Gson().fromJson(value, Movie::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: Movie) {
        bundle.putParcelable(key, value)
    }

}
