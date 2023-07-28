impl Solution {
    pub fn get_permutation(n: i32, k: i32) -> String {
        
        let mut n = n;
        let mut k = k;
        let mut result = String::new();
        let mut nums = Vec::new();
        for i in 1..=n {
            nums.push(i);
        }
        let mut factorial = 1;
        for i in 1..n {
            factorial *= i;
        }
        k -= 1;
        while n > 0 {
            let index = k / factorial;
            result += nums[index as usize].to_string().as_str();
            nums.remove(index as usize);
            k %= factorial;
            if n > 1 {
                factorial /= n - 1;
            }
            n -= 1;
        }
        result
    }
}