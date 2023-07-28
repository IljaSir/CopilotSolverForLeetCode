impl Solution {
    pub fn get_permutation(n: i32, k: i32) -> String {
        
        let mut nums: Vec<i32> = Vec::new();
        let mut k = k;
        let mut fact = 1;
        for i in 1..n {
            fact *= i;
            nums.push(i);
        }
        nums.push(n);
        let mut res = String::new();
        k -= 1;
        for i in (1..n).rev() {
            let idx = k / fact;
            res.push((nums[idx as usize] + 48) as u8 as char);
            nums.remove(idx as usize);
            k -= idx * fact;
            fact /= i;
        }
        res.push((nums[0] + 48) as u8 as char);
        res
    }
}