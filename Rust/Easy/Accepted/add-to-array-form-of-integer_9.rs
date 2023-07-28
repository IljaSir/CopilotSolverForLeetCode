impl Solution {
    pub fn add_to_array_form(num: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut res = Vec::new();
        let mut k = k;
        let mut i = num.len() - 1;
        while i < num.len() {
            let mut n = num[i] + k % 10;
            k /= 10;
            if n >= 10 {
                k += 1;
                n -= 10;
            }
            res.push(n);
            if i == 0 {
                break;
            }
            i -= 1;
        }
        while k > 0 {
            res.push(k % 10);
            k /= 10;
        }
        res.reverse();
        res
    }
}