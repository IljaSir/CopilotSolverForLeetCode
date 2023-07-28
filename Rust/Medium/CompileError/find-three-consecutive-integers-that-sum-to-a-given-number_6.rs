impl Solution {
    pub fn sum_of_three(num: i64) -> Vec<i64> {
        
        let mut i = 1;
        while i * (i + 1) / 2 <= num {
            if i * (i + 1) / 2 == num {
                return vec![1, i, i + 1];
            }
            let j = i + 1;
            let mut k = num - i * (i + 1) / 2;
            while j * (j + 1) / 2 <= k {
                if j * (j + 1) / 2 == k {
                    return vec![i + 1, j + 1, j + 2];
                }
                k -= j;
                j += 1;
            }
            i += 1;
        }
        vec![]
    }
}