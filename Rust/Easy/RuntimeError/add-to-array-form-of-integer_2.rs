impl Solution {
    pub fn add_to_array_form(num: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut k = k;
        let mut num = num;
        let mut i = num.len() - 1;
        while k > 0 {
            if i >= 0 {
                num[i] += k % 10;
                k /= 10;
                if num[i] >= 10 {
                    num[i] -= 10;
                    k += 1;
                }
                i -= 1;
            } else {
                num.insert(0, k % 10);
                k /= 10;
            }
        }
        num
    }
}