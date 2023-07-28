impl Solution {
    pub fn sum_of_three(num: i64) -> Vec<i64> {
        
        if num < 3 {
            return vec![];
        }
        let mut i = 1;
        let mut j = 2;
        let mut k = 3;
        let mut sum = i + j + k;
        while sum < num {
            k += 1;
            sum += k;
        }
        while sum > num {
            sum -= i;
            i += 1;
        }
        if sum == num {
            return vec![i, j, k];
        }
        vec![]
    }
}