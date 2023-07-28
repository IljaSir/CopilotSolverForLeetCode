impl Solution {
    pub fn avoid_flood(rains: Vec<i32>) -> Vec<i32> {
        
        let mut dry: Vec<usize> = Vec::new();
        let mut lakes: Vec<i32> = vec![-1; 10_000];
        let mut ans: Vec<i32> = vec![-1; rains.len()];
        for i in 0..rains.len() {
            let lake = rains[i];
            if lake == 0 {
                dry.push(i);
            } else {
                if lakes[lake as usize - 1] != -1 {
                    let mut index = 0;
                    while index < dry.len() && dry[index] < lakes[lake as usize - 1] as usize {
                        index += 1;
                    }
                    if index == dry.len() {
                        return Vec::new();
                    } else {
                        ans[dry[index]] = lake;
                        dry.remove(index);
                    }
                }
                ans[i] = -1;
                lakes[lake as usize - 1] = i as i32;
            }
        }
        for i in dry {
            ans[i] = 1;
        }
        ans
    }
}