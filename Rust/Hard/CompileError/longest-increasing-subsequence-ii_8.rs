impl Solution {
    pub fn length_of_lis(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut lis = vec![];
        for &n in nums.iter() {
            let i = lis.binary_search_by(|&x| x.0.cmp(&n)).unwrap_or_else(|x| x);
            if i == lis.len() {
                lis.push((n, 1));
            } else {
                lis[i].0 = n;
                lis[i].1 += 1;
            }
            if i > 0 {
                lis[i].1 = std::cmp::max(lis[i].1, lis[i-1].1 + 1);
            }
            if i + 1 < lis.len() && lis[i].0 - lis[i+1].0 > k {
                lis.remove(i+1);
            }
        }
        lis.last().unwrap().1
    }
}