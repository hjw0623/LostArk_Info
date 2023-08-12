package com.example.fp.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.fp.databinding.FragmentCharactersBinding
import com.example.fp.response.CharacterInfo
import com.example.fp.response.Sibling
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


        binding.btnSearch.setOnClickListener {
            val inputMethodManager = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(binding.etCharacterSearch.windowToken, 0)

            val searchName: String = binding.etCharacterSearch.text.toString()

            getCharacterInfo(searchName, Constants.Key)


        }


        mBinding = binding
        return mBinding?.root

    }
    private fun searchSibling(characterName: String, key: String) {
        val retrofit = RetrofitClient.getClient(Constants.BASE_URL)
        val api = retrofit?.create(IRetrofit::class.java)
        val call = api?.searchCharacterSiblings(characterName, "application/json", key)
        call?.enqueue(object : Callback<Sibling>{
            override fun onResponse(
                call: Call<Sibling>,
                response: Response<Sibling>
            ) {
                if (response.isSuccessful){
                    Log.d("TAG", "onResponse: ${response.body()}")

                } else {
                    Log.d("TAG", "onResponse: ${response.errorBody()}")
                }

            }

            override fun onFailure(call: Call<Sibling>, t: Throwable) {
                Log.d("TAG", "onFailure: ${t.message}")
            }

        })
    }

    private fun getCharacterInfo(characterName: String, key: String){
        val retrofit = RetrofitClient.getClient(Constants.BASE_URL)
        val api = retrofit?.create(IRetrofit::class.java)
        val call = api?.getCharacterInfo(characterName, "application/json", key)
        call?.enqueue(object :Callback<CharacterInfo>{
            override fun onResponse(call: Call<CharacterInfo>, response: Response<CharacterInfo>) {
               if (response.isSuccessful){
                   Log.d("TAG", "응답받았음")
                   if (response.body() == null){
                       Toast.makeText(context, "캐릭터를 찾을 수 없습니다.", Toast.LENGTH_SHORT).show()
                       return
                   } else {
                       addCharacterInfo(response.body()!!)
                       mBinding?.scrollView?.visibility = View.VISIBLE
                   }
               }
            }

            override fun onFailure(call: Call<CharacterInfo>, t: Throwable) {
                Log.d("TAG", "연결실패")
            }

        })
    }
    private fun addCharacterInfo(result: CharacterInfo){
        //데이터 설정
        val amoryProfile = result.armoryProfile
        val collectibles = result.collectibles

        val characterName = amoryProfile.characterName
        val characterSever = amoryProfile.serverName
        val characterGuild = amoryProfile.guildName
        val characterClass = amoryProfile.characterClassName
        val characterTitle = amoryProfile.title
        val characterBattleLvl = amoryProfile.characterLevel
        val characterItemLvl = amoryProfile.itemAvgLevel
        val characterExpeditionLvl = amoryProfile.expeditionLevel
        val characterPvp = amoryProfile.pvpGradeName
        val characterTownName = amoryProfile.townName
        val characterImg = amoryProfile.characterImage
        val mococo = collectibles[0]
        val islandHeart = collectibles[1]
        val art = collectibles[2]
        val giantHeart = collectibles[3]
        val ignesia = collectibles[4]
        val sailingAdventure = collectibles[5]
        val treeLeaves = collectibles[6]
        val orpheusStar = collectibles[7]
        val memoryOrgel = collectibles[8]


        //이미지 뷰
        val characterImgView = mBinding?.ivCharacterImage
        val mococoImgView = mBinding?.ivMococo
        val islandHeartImgView = mBinding?.ivIslandHeart
        val artImgView = mBinding?.ivArt
        val giantHeartImgView = mBinding?.ivGiantHeart
        val ignesiaImgView = mBinding?.ivIgnesia
        val sailingAdventureImgView = mBinding?.ivSailingAdventure
        val treeLeavesImgView = mBinding?.ivTreeLeaves
        val orpheusStarImgView = mBinding?.ivOrpheusStar
        val memoryOrgelImgView = mBinding?.ivMemoryOrgel

        //데이터 바인딩

        //캐릭터 정보
        mBinding?.tvCharacterName?.text = characterName
        if(characterGuild != null) {
             mBinding?.tvGuild?.text =characterGuild.toString()
        } else
            mBinding?.tvGuild?.text ="없음"

        mBinding?.tvServer?.text = characterSever
        mBinding?.tvClass?.text = characterClass
        mBinding?.tvTitle?.text = characterTitle
        mBinding?.tvBattlelvl?.text = characterBattleLvl.toString()
        mBinding?.tvItemlvl?.text = characterItemLvl
        mBinding?.tvExpeditionlvl?.text = characterExpeditionLvl.toString()
        mBinding?.tvPvp?.text = characterPvp
        mBinding?.tvTown?.text = characterTownName
        Glide.with(this).load(characterImg).into(characterImgView!!)

        //수집형 포인트
        Glide.with(this).load(mococo.icon).into(mococoImgView!!)
        mBinding?.tvMococo?.text = mococo.point.toString()
        Glide.with(this).load(islandHeart.icon).into(islandHeartImgView!!)
        mBinding?.tvIslandHeart?.text = islandHeart.point.toString()
        Glide.with(this).load(art.icon).into(artImgView!!)
        mBinding?.tvArt?.text = art.point.toString()
        Glide.with(this).load(giantHeart.icon).into(giantHeartImgView!!)
        mBinding?.tvGiantHeart?.text = giantHeart.point.toString()
        Glide.with(this).load(ignesia.icon).into(ignesiaImgView!!)
        mBinding?.tvIgnesia?.text = ignesia.point.toString()
        Glide.with(this).load(sailingAdventure.icon).into(sailingAdventureImgView!!)
        mBinding?.tvSailingAdventure?.text = sailingAdventure.point.toString()
        Glide.with(this).load(treeLeaves.icon).into(treeLeavesImgView!!)
        mBinding?.tvTreeLeaves?.text = treeLeaves.point.toString()
        Glide.with(this).load(orpheusStar.icon).into(orpheusStarImgView!!)
        mBinding?.tvOrpheusStar?.text = orpheusStar.point.toString()
        Glide.with(this).load(memoryOrgel.icon).into(memoryOrgelImgView!!)
        mBinding?.tvMemoryOrgel?.text = memoryOrgel.point.toString()
















    }
    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}
