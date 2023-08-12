package com.example.fp.response


import com.google.gson.annotations.SerializedName

data class CharacterInfo(
    @SerializedName("ArmoryAvatars")
    val armoryAvatars: List<ArmoryAvatar>,
    @SerializedName("ArmoryCard")
    val armoryCard: ArmoryCard,
    @SerializedName("ArmoryEngraving")
    val armoryEngraving: ArmoryEngraving,
    @SerializedName("ArmoryEquipment")
    val armoryEquipment: List<ArmoryEquipment>,
    @SerializedName("ArmoryGem")
    val armoryGem: Any,
    @SerializedName("ArmoryProfile")
    val armoryProfile: ArmoryProfile,
    @SerializedName("ArmorySkills")
    val armorySkills: List<ArmorySkill>,
    @SerializedName("Collectibles")
    val collectibles: List<Collectible>,
    @SerializedName("ColosseumInfo")
    val colosseumInfo: ColosseumInfo
)
data class ArmorySkill(
    @SerializedName("Icon")
    val icon: String,
    @SerializedName("IsAwakening")
    val isAwakening: Boolean,
    @SerializedName("Level")
    val level: Int,
    @SerializedName("Name")
    val name: String,
    @SerializedName("Rune")
    val rune: Rune,
    @SerializedName("Tooltip")
    val tooltip: String,
    @SerializedName("Tripods")
    val tripods: List<Tripod>,
    @SerializedName("Type")
    val type: String
)
data class ArmoryAvatar(
    @SerializedName("Grade")
    val grade: String,
    @SerializedName("Icon")
    val icon: String,
    @SerializedName("IsInner")
    val isInner: Boolean,
    @SerializedName("IsSet")
    val isSet: Boolean,
    @SerializedName("Name")
    val name: String,
    @SerializedName("Tooltip")
    val tooltip: String,
    @SerializedName("Type")
    val type: String
)
data class ArmoryCard(
    @SerializedName("Cards")
    val cards: List<Card>,
    @SerializedName("Effects")
    val effects: List<Effect>
)
data class ArmoryEngraving(
    @SerializedName("Effects")
    val effects: List<EffectX>,
    @SerializedName("Engravings")
    val engravings: List<Engraving>
)
data class Rune(
    @SerializedName("Grade")
    val grade: String,
    @SerializedName("Icon")
    val icon: String,
    @SerializedName("Name")
    val name: String,
    @SerializedName("Tooltip")
    val tooltip: String
)
data class ArmoryEquipment(
    @SerializedName("Grade")
    val grade: String,
    @SerializedName("Icon")
    val icon: String,
    @SerializedName("Name")
    val name: String,
    @SerializedName("Tooltip")
    val tooltip: String,
    @SerializedName("Type")
    val type: String
)
data class ArmoryProfile(
    @SerializedName("CharacterClassName")
    val characterClassName: String,
    @SerializedName("CharacterImage")
    val characterImage: String,
    @SerializedName("CharacterLevel")
    val characterLevel: Int,
    @SerializedName("CharacterName")
    val characterName: String,
    @SerializedName("ExpeditionLevel")
    val expeditionLevel: Int,
    @SerializedName("GuildMemberGrade")
    val guildMemberGrade: Any,
    @SerializedName("GuildName")
    val guildName: Any,
    @SerializedName("ItemAvgLevel")
    val itemAvgLevel: String,
    @SerializedName("ItemMaxLevel")
    val itemMaxLevel: String,
    @SerializedName("PvpGradeName")
    val pvpGradeName: String,
    @SerializedName("ServerName")
    val serverName: String,
    @SerializedName("Stats")
    val stats: List<Stat>,
    @SerializedName("Tendencies")
    val tendencies: List<Tendency>,
    @SerializedName("Title")
    val title: String,
    @SerializedName("TotalSkillPoint")
    val totalSkillPoint: Int,
    @SerializedName("TownLevel")
    val townLevel: Int,
    @SerializedName("TownName")
    val townName: String,
    @SerializedName("UsingSkillPoint")
    val usingSkillPoint: Int
)
data class Card(
    @SerializedName("AwakeCount")
    val awakeCount: Int,
    @SerializedName("AwakeTotal")
    val awakeTotal: Int,
    @SerializedName("Grade")
    val grade: String,
    @SerializedName("Icon")
    val icon: String,
    @SerializedName("Name")
    val name: String,
    @SerializedName("Slot")
    val slot: Int,
    @SerializedName("Tooltip")
    val tooltip: String
)
data class Collectible(
    @SerializedName("CollectiblePoints")
    val collectiblePoints: List<CollectiblePoint>,
    @SerializedName("Icon")
    val icon: String,
    @SerializedName("MaxPoint")
    val maxPoint: Int,
    @SerializedName("Point")
    val point: Int,
    @SerializedName("Type")
    val type: String
)
data class CollectiblePoint(
    @SerializedName("MaxPoint")
    val maxPoint: Int,
    @SerializedName("Point")
    val point: Int,
    @SerializedName("PointName")
    val pointName: String
)
data class Colosseum(
    @SerializedName("CoOpBattle")
    val coOpBattle: Any,
    @SerializedName("Competitive")
    val competitive: Any,
    @SerializedName("Deathmatch")
    val deathmatch: Any,
    @SerializedName("SeasonName")
    val seasonName: String,
    @SerializedName("TeamDeathmatch")
    val teamDeathmatch: Any,
    @SerializedName("TeamElimination")
    val teamElimination: Any
)
data class ColosseumInfo(
    @SerializedName("Colosseums")
    val colosseums: List<Colosseum>,
    @SerializedName("Exp")
    val exp: Int,
    @SerializedName("PreRank")
    val preRank: Int,
    @SerializedName("Rank")
    val rank: Int
)
data class Effect(
    @SerializedName("CardSlots")
    val cardSlots: List<Int>,
    @SerializedName("Index")
    val index: Int,
    @SerializedName("Items")
    val items: List<Item>
)
data class EffectX(
    @SerializedName("Description")
    val description: String,
    @SerializedName("Name")
    val name: String
)
data class Engraving(
    @SerializedName("Icon")
    val icon: String,
    @SerializedName("Name")
    val name: String,
    @SerializedName("Slot")
    val slot: Int,
    @SerializedName("Tooltip")
    val tooltip: String
)
data class Item(
    @SerializedName("Description")
    val description: String,
    @SerializedName("Name")
    val name: String
)
data class Stat(
    @SerializedName("Tooltip")
    val tooltip: List<String>,
    @SerializedName("Type")
    val type: String,
    @SerializedName("Value")
    val value: String
)
data class Tendency(
    @SerializedName("MaxPoint")
    val maxPoint: Int,
    @SerializedName("Point")
    val point: Int,
    @SerializedName("Type")
    val type: String
)
data class Tripod(
    @SerializedName("Icon")
    val icon: String,
    @SerializedName("IsSelected")
    val isSelected: Boolean,
    @SerializedName("Level")
    val level: Int,
    @SerializedName("Name")
    val name: String,
    @SerializedName("Slot")
    val slot: Int,
    @SerializedName("Tier")
    val tier: Int,
    @SerializedName("Tooltip")
    val tooltip: String
)