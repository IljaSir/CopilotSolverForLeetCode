impl Solution {
    pub fn find_radius(houses: Vec<i32>, heaters: Vec<i32>) -> i32 {
        

        let mut heaters = heaters;
        heaters.sort();
        let mut ans = 0;
        for house in houses {
            let mut l = 0;
            let mut r = heaters.len() - 1;
            while l < r {
                let mid = (l + r) / 2;
                if heaters[mid] < house {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            let dist1 = (heaters[l] - house).abs();
            let dist2 = if l > 0 {
                (heaters[l - 1] - house).abs()
            } else {
                i32::MAX
            };
            ans = ans.max(dist1.min(dist2));
        }
        ans
    }
}