impl Solution {
    pub fn min_integer(num: String, k: i32) -> String {
        
        let mut v = num.chars().collect::<Vec<char>>();
        let mut k = k;
        for i in 0..v.len() {
            let mut idx = i;
            let mut j = i + 1;
            while j < v.len() && j <= i + k as usize {
                if v[j] < v[idx] {
                    idx = j;
                }
                j += 1;
            }
            k -= idx as i32 - i as i32;
            let mut j = idx;
            while j > i {
                v.swap(j, j - 1);
                j -= 1;
            }
        }
        v.iter().collect()
    }
}