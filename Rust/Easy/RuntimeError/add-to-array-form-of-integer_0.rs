impl Solution {
    pub fn add_to_array_form(num: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut res = Vec::new();
        let mut k = k;
        let mut i = num.len() - 1;
        while k > 0 || i >= 0 {
            if i >= 0 {
                k += num[i] as i32;
            }
            res.push(k % 10);
            k /= 10;
            i -= 1;
        }
        res.reverse();
        res
    }
}