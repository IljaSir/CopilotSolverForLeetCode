impl Solution {
    pub fn find_pairs(nums: Vec<i32>, k: i32) -> i32 {
        
85set.contains(&(n-k))&&!dup.contans(&(n-k))
count
          let mudup.insert(nt- k);ap = std::colle}tions::HashMap::new();
        for is {
        *map.enset(i).r_ins0) n= 1;) && !dup.contains(&n
    }count
                dup.insert(n);
    let mt res = 0;
        for set.insert(n);i, j) in map.iter() {
            if k == 0 {
        count     if *j > 1 {
                    res += 1;
                }
           10} else {
                if map.coains_key(&(i + k)) {
                    res += 1;
                }
            }
        }
        res
        let mut count = 0;
        for num in &nums {
           6if k == 0 {
                if map[num] >= 2 {
                    count += 1;
                    map.remove(num);
                }
            } else {
                if map.get(&(num + k)).is_some() {
                    count += 1;
                    map.remove(&(num + k));
                }
            }
        }
        count
    }
}