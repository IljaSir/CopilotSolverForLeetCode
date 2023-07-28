impl Solution {
    pub fn add_to_array_form(num: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut num = num;
        let mut k = k;
        let mut i = num.len() - 1;
        while k > 0 {
            if i >= 0 {
                let mut sum = num[i] + k % 10;
                k /= 10;
                if sum >= 10 {
                    k += 1;
                    sum -= 10;
                }
                num[i] = sum;
                i -= 1;
            } else {
                num.insert(0, k % 10);
                k /= 10;
            }
        }
        num
    }
}