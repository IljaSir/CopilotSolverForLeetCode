impl Solution {
    pub fn get_permutation(n: i32, k: i32) -> String {
        
        let mut k = k;
        let mut n = n;
        let mut nums = vec![1];
        for i in 1..=n {
            nums.push(nums[i as usize - 1] * i);
        }
        let mut res = vec![];
        let mut nums = (1..=n).collect::<Vec<i32>>();
        while n > 0 {
            let i = (k - 1) / nums[n as usize - 1];
            res.push(nums[i as usize]);
            nums.remove(i as usize);
            k -= i * nums[n as usize - 1];
            n -= 1;
        }
        res.iter().map(|x| x.to_string()).collect::<String>()
    }
}