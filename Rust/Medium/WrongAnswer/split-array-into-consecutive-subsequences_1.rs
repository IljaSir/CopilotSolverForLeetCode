impl Solution {
    pub fn is_possible(nums: Vec<i32>) -> bool {
        

        let mut count = std::collections::HashMap::new();
        for &num in nums.iter() {
            *count.entry(num).or_insert(0) += 1;
        }
        let mut tails = std::collections::HashMap::new();
        for &num in nums.iter() {
            if let Some(&c) = count.get(&num) {
                if c > 0 {
                    if let Some(&t) = tails.get(&(num - 1)) {
                        if t > 0 {
                            *count.get_mut(&num).unwrap() -= 1;
                            *tails.get_mut(&(num - 1)).unwrap() -= 1;
                            *tails.entry(num).or_insert(0) += 1;
                        } else {
                            if let Some(&c) = count.get(&(num + 1)) {
                                if c > 0 {
                                    if let Some(&c) = count.get(&(num + 2)) {
                                        if c > 0 {
                                            *count.get_mut(&(num + 1)).unwrap() -= 1;
                                            *count.get_mut(&(num + 2)).unwrap() -= 1;
                                            *tails.entry(num + 2).or_insert(0) += 1;
                                        } else {
                                            return false;
                                        }
                                    } else {
                                        return false;
                                    }
                                } else {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                        }
                    } else {
                        if let Some(&c) = count.get(&(num + 1)) {
                            if c > 0 {
                                if let Some(&c) = count.get(&(num + 2)) {
                                    if c > 0 {
                                        *count.get_mut(&(num + 1)).unwrap() -= 1;
                                        *count.get_mut(&(num + 2)).unwrap() -= 1;
                                        *tails.entry(num + 2).or_insert(0) += 1;
                                    } else {
                                        return false;
                                    }
                                } else {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        true
    }
}