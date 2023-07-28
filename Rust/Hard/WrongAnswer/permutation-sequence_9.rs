impl Solution {
    pub fn get_permutation(n: i32, k: i32) -> String {
        
        let mut nums = Vec::new();
        let mut fact = Vec::new();
        let mut k = k;
        let n = n as usize;
        fact.push(1);
        for i in 1..n {
            fact.push(fact[i - 1] * i as i32);
        }
        for i in 1..=n as i32 {
            nums.push(i);
        }
        let mut res = String::new();
        for i in (1..n).rev() {
            let idx = ((k - 1) / fact[i - 1]) as usize;
            res.push((b'0' + nums[idx] as u8) as char);
            nums.remove(idx);
            k -= idx as i32 * fact[i - 1];
        }
        res.push((b'0' + nums[0] as u8) as char);
        res
    }
}