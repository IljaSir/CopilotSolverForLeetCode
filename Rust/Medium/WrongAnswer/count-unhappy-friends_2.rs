impl Solution {
    pub fn unhappy_friends(n: i32, preferences: Vec<Vec<i32>>, pairs: Vec<Vec<i32>>) -> i32 {
        
        let n = n as usize;
        let mut friends = vec![vec![0; n]; n];
        for (i, p) in preferences.iter().enumerate() {
            for (j, v) in p.iter().enumerate() {
                friends[i][*v as usize] = j;
            }
        }
        let mut pairs = pairs;
        pairs.sort_by_key(|x| x[0]);
        let mut ans = 0;
        for i in 0..n {
            let mut j = 0;
            while j < n && friends[i][pairs[j][0] as usize] < friends[i][pairs[j][1] as usize] {
                j += 1;
            }
            if j < n {
                ans += 1;
                continue;
            }
            j = 0;
            while j < n && friends[i][pairs[j][0] as usize] > friends[i][pairs[j][1] as usize] {
                j += 1;
            }
            if j < n {
                ans += 1;
            }
        }
        ans
    }
}