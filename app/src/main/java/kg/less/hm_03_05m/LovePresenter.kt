package kg.less.hm_03_05m

import kg.less.hm_03_05m.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LovePresenter(private val contract: LoveContract) {

    private val api = RetrofitService.api

    fun getPercentage(firsName: String, secondName: String) {
        api.getPercent(
            apiKey = "c9ca6be028msh6d10d8cc640195dp1001edjsn6b0748def79b",
            host = "love-calculator.p.rapidapi.com",
            firstName = firsName,
            secondName = secondName
        ).enqueue(object : Callback<LoveModel> {

            override fun onResponse(p0: Call<LoveModel>, p1: Response<LoveModel>) {
                if (p1.isSuccessful) {
                    p1.body()?.let {
                        contract.showResult(it)
                    } ?: contract.showError("Ответ с пустым телом")
                } else {
                    contract.showError("Ответ не удался: ${p1.message()}")
                }
            }

            override fun onFailure(p0: Call<LoveModel>, p1: Throwable) {
                contract.showError("Ошибка: ${p1.message}")
            }
        }
        )
    }
}
