impl Solution {
    pub fn min_integer(num: String, k: i32) -> String {
        
        let mut num: Vec<char> = num.chars().collect();
        let mut k = k;
        for i in 0..num.len() {
            if k == 0 {
                break;
            }
            let mut min = i;
            for j in i + 1..num.len() {
                if num[j] < num[min] {
                    min = j;
                }
                if j - i > k as usize {
                    break;
                }
            }
            for j in (min + 1..=i).rev() {
                num.swap(j, j - 1);
            }
            k -= (min - i) as i32;
        }
        num.iter().collect()
    }
}