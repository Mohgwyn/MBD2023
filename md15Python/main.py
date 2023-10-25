dict1 = {'bananas': 7, 'apples': 3, 'pears': 14}
dict2 = {'bananas': 3, 'apples': 6, 'grapes': 9}

def merge_max_mappings(dict1, dict2) -> dict:
    dict3 = dict2.copy()
    for key, value in dict1.items():
        if key in dict2.keys():
            dict3[key] = max(value, dict2[key])
        else:
            dict3[key] = value
    return dict3


if __name__ == "__main__":
    print(merge_max_mappings(dict1, dict2))