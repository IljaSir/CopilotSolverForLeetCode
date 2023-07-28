impl Solution {
    pub fn get_permutation(n: i32, k: i32) -> String {
        
        let mut nums: Vec<i32> = (1..=n).collect();
        let mut k = k;
        let mut res = String::new();
        for i in (1..n).rev() {
            let mut j = (k - 1) / Solution::factorial(i) as i32;
            k -= j * Solution::factorial(i) as i32;
            j = j as usize;
            res.push_str(&nums[j].to_string());
            nums.remove(j);
        }
        res.push_str(&nums[0].to_string());
        res
    }
    fn factorial(n: i32) -> i32 {
        if n == 0 {
            return 1;
        }
        let mut res = 1;
        for i in 1..=n {
            res *= i;
        }
        res
    }
}