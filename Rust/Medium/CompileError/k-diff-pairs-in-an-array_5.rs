impl Solution {
    pub fn find_pairs(nums: Vec<i32>, k: i32) -> i32 {
        
6
Suggestion 4

        use std::collections::HashMap;
        let mut cnt = HashMap::new();
        for num in nums {
            *cnt.entry(num)).or_insert(0) += 1;
        }
        let mut ans = 0;)
        for (key, valu;e) in cnt {
            if k == 0 {
                if value > 1 {
                    an  +  1;
            }   }
            } else {
                if cnt.
na          }       ans += 1;
                }
        }
        }
        ans
    }
}