package com.example.a55

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        class Solution {
            fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
                var answer: String = ""
                /*
                var resultCard = Array<String?>(goal.size,{""})
                var cards1_index :Int = 0
                var cards2_index :Int = 0
                var checked_card :Boolean = true//참일경우 card1 아니면 card2
                //cards1 에서 원하는 단어를 찾아서 없을때 card2로 넘어가서 찾는다
                loop@for(index in 0..goal.size-1){
                    //card1 비교
                    if(checked_card) {
                        for (index_1 in cards1_index..cards1.size - 1) {
                            if (cards1.get(index_1) == goal.get(index)) {
                                cards1_index++//읽은 카드는 다시볼 필요없으므로
                                resultCard.set(index, cards1.get(index_1))
                                checked_card=false
                                continue@loop
                            }
                        }
                        checked_card=false
                    }
                    if(!checked_card) {
                        for (index_2 in cards2_index..cards1.size - 1) {
                            if (cards2.get(index_2) == goal.get(index)) {
                                cards2_index++//읽은 카드는 다시볼 필요없으므로
                                resultCard.set(index, cards2.get(index_2))
                                checked_card=true
                                continue@loop
                            }
                        }
                        checked_card=true
                    }




                }
                */

                //스택과 큐 자료구조로 해결가능하지 않을까?
                //기존에 주어진 카드뭉치의 단어 순서는 바꿀수없다 >> 큐 구조
                //큐 구조로 재정의 이후 goal 값을 비교하여 빼면 될듯 ㅇㅇ
                val que1 : Queue<String> = LinkedList()
                val que2 : Queue<String> = LinkedList()
                val que_goal : Queue<String> = LinkedList()
                //que 값 입력
                for(index in 0..cards1.size-1)
                    que1.add(cards1.get(index))
                for(index in 0..cards2.size-1)
                    que2.add(cards2.get(index))
                for(index in 0..goal.size-1)
                    que_goal.add(goal.get(index))

                //goal 값을 비교하는 알고리즘 구현
                for(index in 0..goal.size-1){
                    if(goal[index].equals(que1.peek())){
                        que1.poll()
                        que_goal.poll()
                    }
                    else if(goal[index].equals(que2.peek())) {
                        que2.poll()
                        que_goal.poll()
                    }
                    else //더이상 만들수없는 경우 break
                        break
                }
                //que값들이 완벽히 비어있으면 yes?
                // --> goals값도 que형태로 만들어서 그값이 비어있으면 Yes!(카드뭉치가 남은경우를 고려)
                if(que_goal.isEmpty()) answer ="Yes"
                else answer ="No"

                return answer
            }
        }
        val a = Solution()
        a.solution(arrayOf<String>("i", "drink", "water"),arrayOf<String>("want", "to"),arrayOf<String>("i", "want", "to", "drink", "water"))
        a.solution(arrayOf<String>("i", "water", "drink"),arrayOf<String>("want", "to"),arrayOf<String>("i", "want", "to", "drink", "water"))

    }
}