impl Solution {
    pub fn unhappy_friends(n: i32, preferences: Vec<Vec<i32>>, pairs: Vec<Vec<i32>>) -> i32 {
        
        let n = n as usize;
        let mut pref = vec![vec![-1; n]; n];
        for i in 0..n {
            for j in 0..n - 1 {
                pref[i][preferences[i][j] as usize] = j as i32;
            }
        }
        let mut pair = vec![vec![-1; 2]; n];
        for i in 0..n / 2 {
            pair[pairs[i][0] as usize][0] = pairs[i][1];
            pair[pairs[i][1] as usize][0] = pairs[i][0];
            pair[pairs[i][0] as usize][1] = pref[pairs[i][0] as usize][pairs[i][1] as usize];
            pair[pairs[i][1] as usize][1] = pref[pairs[i][1] as usize][pairs[i][0] as usize];
        }
        let mut res = 0;
        for i in 0..n {
            for j in 0..2 {
                let x = pair[i][0];
                let y = pair[i][1];
                if x == -1 || y == -1 {
                    break;
                }
                let u = pair[x as usize][0];
                let v = pair[x as usize][1];
                if u != -1 && v != -1 && pref[x as usize][i] < v && pref[i][x as usize] < pref[i][y as usize] {
                    res += 1;
                    break;
                }
            }
        }
        res
    }
}