impl Solution {
    pub fn min_integer(num: String, k: i32) -> String {
        
        let mut num = num.chars().collect::<Vec<_>>();
        let mut k = k;
        let mut i = 0;
        while i < num.len() - 1 && k > 0 {
            let mut min = i;
            let mut j = i + 1;
            while j < num.len() && j - i <= k as usize {
                if num[j] < num[min] {
                    min = j;
                }
                j += 1;
            }
            for j in (min + 1..=i + k as usize).rev() {
                num.swap(j, j - 1);
            }
            k -= (min - i) as i32;
            i += 1;
        }
        num.into_iter().collect()
    }
}