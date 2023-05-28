package com.example.lolchampions

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ChampInfo(
    @StringRes val champName: Int,
    @StringRes val role: Int,
    @DrawableRes val champImg: Int,
    @StringRes val summarization: Int
)

val champInfoList = listOf(
    ChampInfo(
        R.string.aatrox,
        R.string.fighter,
        R.drawable.aatrox,
        R.string.aatrox_sum
    ),
    ChampInfo(
        R.string.akali,
        R.string.assassin,
        R.drawable.akali,
        R.string.akali_sum
    ),
    ChampInfo(
        R.string.aphelios,
        R.string.marksman,
        R.drawable.aphelios,
        R.string.aphelios_sum
    ),
    ChampInfo(
        R.string.caitlyn,
        R.string.marksman,
        R.drawable.caitlyn,
        R.string.caitlyn_sum
    ),
    ChampInfo(
        R.string.diana,
        R.string.fighter,
        R.drawable.diana,
        R.string.diana_sum
    ),
    ChampInfo(
        R.string.ezreal,
        R.string.marksman,
        R.drawable.ezreal,
        R.string.ezreal_sum
    ),
    ChampInfo(
        R.string.garen,
        R.string.fighter,
        R.drawable.garen,
        R.string.garen_sum
    ),
    ChampInfo(
        R.string.ivern,
        R.string.support,
        R.drawable.ivern,
        R.string.ivern_sum
    ),
    ChampInfo(
        R.string.ksante,
        R.string.tanker,
        R.drawable.ksante,
        R.string.ksante_sum
    ),
    ChampInfo(
        R.string.neeko,
        R.string.mage,
        R.drawable.neeko,
        R.string.neeko_sum
    ),
    ChampInfo(
        R.string.ornn,
        R.string.tanker,
        R.drawable.ornn,
        R.string.ornn_sum
    ),
    ChampInfo(
        R.string.rakan,
        R.string.support,
        R.drawable.rakan,
        R.string.rakan_sum
    ),
    ChampInfo(
        R.string.shen,
        R.string.tanker,
        R.drawable.shen,
        R.string.shen_sum
    ),
    ChampInfo(
        R.string.yasuo,
        R.string.fighter,
        R.drawable.yasuo,
        R.string.yasuo_sum
    ),
    ChampInfo(
        R.string.zed,
        R.string.assassin,
        R.drawable.zed,
        R.string.zed_sum
    ),
)
