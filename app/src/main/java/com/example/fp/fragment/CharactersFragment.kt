package com.example.fp.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fp.databinding.FragmentCharactersBinding
import com.example.fp.response.Sibling
import com.example.fp.retrofit.CharacterSiblingsItem
import com.example.fp.retrofit.IRetrofit
import com.example.fp.retrofit.RetrofitClient
import com.example.fp.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CharactersFragment: Fragment() {
    private var mBinding : FragmentCharactersBinding? = null



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCharactersBinding.inflate(inflater, container, false)


        binding.button.setOnClickListener {
            searchSibling("택티컬맘마통", Constants.Key)

        }

        mBinding = binding
        return mBinding?.root

    }
    private fun searchSibling(characterName: String, Key: String) {
        val retrofit = RetrofitClient.getClient(Constants.BASE_URL)
        val api = retrofit?.create(IRetrofit::class.java)
        val call = api?.searchCharacterSiblings(characterName, "application/json", Key)
        call?.enqueue(object : Callback<Sibling>{
            override fun onResponse(
                call: Call<Sibling>,
                response: Response<Sibling>
            ) {
                if (response.isSuccessful){
                    Log.d("TAG", "onResponse: ${response.body()}")
                    mBinding?.textView?.text = response.body().toString()
                } else {
                    Log.d("TAG", "onResponse: ${response.errorBody()}")
                }

            }

            override fun onFailure(call: Call<Sibling>, t: Throwable) {
                Log.d("TAG", "onFailure: ${t.message}")
            }

        })
    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}
