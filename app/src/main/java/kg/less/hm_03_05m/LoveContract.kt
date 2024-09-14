package kg.less.hm_03_05m

import kg.less.hm_03_05m.model.LoveModel

interface LoveContract {
    fun showResult(result: LoveModel)
    fun showError(message: String)
    fun getPercentage(firstName: String, secondName: String)
}