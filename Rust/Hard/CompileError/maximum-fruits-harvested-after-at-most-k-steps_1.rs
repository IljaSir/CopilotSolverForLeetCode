impl Solution {
    pub fn max_total_fruits(fruits: Vec<Vec<i32>>, start_pos: i32, k: i32) -> i32 {
        
        let mut res = 0;
        let mut i = start_pos as usize;
        let mut j = start_pos as usize;
        let mut k = k as usize;
        let mut sum = 0;
        let mut map = std::collections::HashMap::new();
        map.insert(fruits[i][0], fruits[i][1]);
        sum += fruits[i][1];
        while k > 0 && (i > 0 || j + 1 < fruits.len()) {
            if i == 0 {
                j += 1;
                *map.entry(fruits[j][0]).or_insert(0) += fruits[j][1];
                sum += fruits[j][1];
                k -= 1;
            } else if j + 1 == fruits.len() {
                i -= 1;
                *map.entry(fruits[i][0]).or_insert(0) += fruits[i][1];
                sum += fruits[i][1];
                k -= 1;
            } else {
                let d1 = (fruits[i][0] - fruits[i - 1][0]) as usize;
                let d2 = (fruits[j + 1][0] - fruits[j][0]) as usize;
                if d1 <= d2 && d1 <= k {
                    i -= 1;
                    *map.entry(fruits[i][0]).or_insert(0) += fruits[i][1];
                    sum += fruits[i][1];
                    k -= d1;
                } else if d2 <= d1 && d2 <= k {
                    j += 1;
                    *map.entry(fruits[j][0]).or_insert(0) += fruits[j][1];
                    sum += fruits[j][1];
                    k -= d2;
                } else {
                    break;
                }
            }
            if map.len() <= 2 {
                res = res.max(sum);
            } else {
                let mut min = std::i32::MAX;
                let mut min_pos = 0;
                for (pos, &amount) in &map {
                    if amount < min {
                        min = amount;
                        min_pos = pos;
                    }
                }
                sum -= min;
                map.remove(&min_pos);
            }
        }
        res
    }
}