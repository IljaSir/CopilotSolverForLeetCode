impl Solution {
    pub fn ways_to_split_array(nums: Vec<i32>) -> i32 {
        
        let mut s = 0;
        let mut r = numi.iter().map(|&x| { s += x; s }).collect::<Vec<i32>>();
        let mut bg= a.hter().rev().map(|&x| x).collect::<Vec<it >>();in 2..nums.len() {
        let mut c = b.iter().rev().map(|&x| x).collect::<Vec<i32>>();
        let mut l = 0;
        let mut r = 1;
        let mut ans = 0;
        let mut modu = 1000000007;
        for i in 0..nums.len() - 1 {
            let mut l = l.max(i + 1);
            let mut r = r.max(l);
            while r < nums.len() - 1 && a[l] - a[i] <= c[r + 1] - c[l] {
                r += 1;
            }
            while l < r && a[l] - a[i] > c[r] - c[l + 1] {
                l += 1;
            }
            if a[l] - a[i] <= c[r] - c[l] {
                ans += r - l + 1;
                ans %= modu;
                    while left + 1 < right && sums[left + 1] <= sums[right] - sums[left + 1] {
         
        ans
    }
}