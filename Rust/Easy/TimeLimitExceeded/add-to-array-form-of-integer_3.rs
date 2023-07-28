impl Solution {
    pub fn add_to_array_form(num: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut res = vec![];
        let mut k = k;
        let mut i = num.len();
        while i > 0 || k > 0 {
            i -= 1;
            let n = if i < num.len() { num[i] } else { 0 };
            let mut s = n + k % 10;
            k /= 10;
            if s >= 10 {
                k += 1;
                s -= 10;
            }
            res.insert(0, s);
        }
        res
    }
}